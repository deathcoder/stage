package it.objectway.corsi.ecommerce.servlet;

import it.objectway.corsi.ecommerce.impl.LogManagerImpl;
import it.objectway.corsi.ecommerce.impl.ProductDaoImpl;
import it.objectway.corsi.ecommerce.interfaces.LogManager;
import it.objectway.corsi.ecommerce.interfaces.ProductDao;
import it.objectway.corsi.ecommerce.models.BasketProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stageusr2015 on 05/06/2015.
 */
@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
    private static final LogManager logger = new LogManagerImpl(BasketServlet.class);
    private static final ProductDao dao = new ProductDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.trace("doPost: start");
        String action = request.getParameter("action");
        logger.debug("doPost: action(", request.getParameter("action"), ")");
        if(action != null && action.equals("update")) {
            doPut(request, response);
            return;
        }
        logger.debug("doPost: amount(", request.getParameter("amount"), "), product id(", request.getParameter("id"), ")");
        Integer amount = new Integer(request.getParameter("amount"));
        Integer product = new Integer(request.getParameter("id"));
        addToSessionBasket(product, amount, request);
        dispatchToBasket(request, response);
    }

    private void addToSessionBasket(int product, int amount, HttpServletRequest request) {
        logger.debug("addToSessionBasket: start");
        HttpSession session = request.getSession();
        Map<Integer, BasketProduct> basket = (Map<Integer, BasketProduct>) session.getAttribute("basket");
        if(basket == null) {
            basket = new HashMap<>();
            session.setAttribute("basket", basket);
        }
        if(amount == 0) {
            basket.remove(product);
            return;
        }
        BasketProduct basketProduct = basket.get(product);
        if (basketProduct == null) {
            basket.put(product, new BasketProduct(dao.getProduct(product), amount));
        }
        else {
            basketProduct.setAmount(amount);
        }
        logger.debug("addToSessionBasket: basket(", basket, ")");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatchToBasket(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.trace("doPut: start");
        logger.debug("doPut: amount(", request.getParameterValues("amount"),
                ") product(", request.getParameterValues("product"), ")");
        String[] amounts = request.getParameterValues("amount");
        String[] products = request.getParameterValues("product");
        for(int i = 0; i < Math.min(amounts.length, products.length); i++) {
            addToSessionBasket(new Integer(products[i]), new Integer(amounts[i]), request);
        }
        dispatchToBasket(request, response);
    }

    private void dispatchToBasket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/basket.jsp");
        rd.forward(request, response);
    }
}
