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
@WebServlet("/home")
public class ListProductsServlet extends HttpServlet {
    private static DaoProduct daoProduct = new DaoProductImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("prodList", daoProduct.getProductList());

        request.setAttribute("htmlTagData", "<br/> creates a new line.");
        /*request.setAttribute("url", "http://www.journaldev.com");*/
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
}
