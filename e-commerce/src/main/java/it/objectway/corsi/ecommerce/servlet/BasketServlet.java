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
        logger.debug("doPost: amount(", request.getParameter("amount"), "), prod_id(", request.getParameter("id"), ")");
        Integer amount = new Integer(request.getParameter("amount"));
        Integer prod_id = new Integer(request.getParameter("id"));
        HttpSession session = request.getSession();
        Map<Integer, BasketProduct> basket = (Map<Integer, BasketProduct>) session.getAttribute("basket");
        if(basket == null) {
            basket = new HashMap<>();
            session.setAttribute("basket", basket);
        }
        BasketProduct product = basket.get(prod_id);
        if (product == null) {
            basket.put(prod_id, new BasketProduct(dao.getProduct(prod_id), amount));
        }
        else {
            product.setAmount(amount);
        }
        logger.debug("doPost: basket(", basket, ")");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/basket.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/basket.jsp");
        rd.forward(request, response);
    }
}
