package it.objectway.corsi.ecommerce.servlet;

import it.objectway.corsi.ecommerce.impl.DaoProductImpl;
import it.objectway.corsi.ecommerce.interfaces.DaoProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pong on 02/06/15.
 */
@WebServlet("/prod/*")
public class ProductDetailServlet extends HttpServlet {
    private static DaoProduct daoProduct = new DaoProductImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("product", daoProduct.getProduct(id));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/product.jsp");
        rd.forward(request, response);
    }
}
