package com.springapp.product;

import com.springapp.dao.ProductDao;
import com.springapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by LalinPethiyagoda on 27/11/2016.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;
    /*@RequestMapping(value="/productList/viewProduct" , method= RequestMethod.GET)
    public String invokeLogin(@RequestParam int Id,
                              ModelMap model) throws IOException{
        model.put("productDetails", productDao.getProductById(Id));
        return "viewProduct";
    }*/

    @RequestMapping(value="/productList/viewProduct" , method= RequestMethod.GET)
    public String viewProduct(@RequestParam int productId,
                              ModelMap model) throws IOException{
        model.put("productDetails", productDao.getProductById(productId));
        return "viewProduct";
    }

    @RequestMapping(value="/productList", method=RequestMethod.GET)
    public String getProducts(ModelMap modelMap){
        modelMap.put("productList", productDao.getAllProducts());

        return "productList";
    }

    @RequestMapping(value="/addProduct", method=RequestMethod.GET)
    public String showNewProduct(ModelMap model){
        ProductImpl newProduct = new ProductImpl();
        newProduct.setProductCategory("Instrument");
        newProduct.setProductCondition("New");
        newProduct.setProductStatus("Active");
        model.addAttribute("newProduct",newProduct);
        return "addProduct";
    }

    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public String adminPage(){
        return "admin";
    }

    @RequestMapping(value="/admin/productInventory", method=RequestMethod.GET)
    public String productInventory(ModelMap model){
        model.addAttribute("productList",productDao.getAllProducts());
        return "productInventory";
    }

    @RequestMapping(value="/admin/productInventory/addProduct", method=RequestMethod.POST)
    public String addProductPost(@ModelAttribute("newProduct") ProductImpl newProduct, HttpServletRequest request){
        //Note to self: HttpServletRequest request is used to get the context path
        productDao.addProduct(newProduct);
        MultipartFile productImage =newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + newProduct.getProductId() + ".png");

        if(productImage!=null || !productImage.isEmpty() ){
            try{
                productImage.transferTo(new File(path.toString()));
                productImage.transferTo(new File("//Users//LalinPethiyagoda//IdeaProjects//WEIndian//src//main//webapp//WEB-INF//resources//images//" + newProduct.getProductId() + ".png"));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value="/admin/productInventory/deleteProduct")
    public String deleteProduct(@RequestParam int productId, ModelMap model , HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + productId + ".png");
        if(Files.exists(path))
        try{
            Files.delete(path);
        }catch(IOException e){
            e.printStackTrace();
        }

        productDao.deleteProduct(productId);
        return "redirect:/admin/productInventory";
    }
    @RequestMapping(value="/admin/productInventory/editProduct" , method=RequestMethod.GET)
    public String editProduct(@RequestParam int productId, ModelMap model , HttpServletRequest request) {
        Product product= productDao.getProductById(productId);
        model.addAttribute("product", product);

        return "editProduct";
    }

    @RequestMapping(value="/admin/productInventory/editProduct", method=RequestMethod.POST)
        public String editProduct(@ModelAttribute("product") ProductImpl product, ModelMap model, HttpServletRequest request){
            MultipartFile productImage = product.getProductImage();
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
            Path path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + product.getProductId()+ ".png");

            if(!productImage.isEmpty() && productImage !=null){
                try{
                   productImage.transferTo(new File(path.toString()));
                }catch (Exception e) {
                    throw new RuntimeException("ProductImpl Image saving failed", e);
                }
            }

        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }

}
