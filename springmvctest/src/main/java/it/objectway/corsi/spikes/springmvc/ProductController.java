package it.objectway.corsi.spikes.springmvc;

import it.objectway.corsi.spikes.springmvc.models.Product;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static it.objectway.corsi.spikes.springmvc.enums.Category.PHONE;

/*
@Controller
@RequestMapping("/")
public class ProductController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
*/
public class ProductController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("iphone", "not cool", PHONE, "800"));
        products.add(new Product("iphone5", "really not cool", PHONE, "850"));

        return new ModelAndView(
                "products", "products", products);
    }
}