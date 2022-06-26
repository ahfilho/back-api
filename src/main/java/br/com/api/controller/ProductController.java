package br.com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.entity.CategoriaProdutoModel;
import br.com.api.entity.ImagemOfertaResponse;
import br.com.api.entity.ImgProdutoModel;
import br.com.api.entity.ProductModel;
import br.com.api.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> productSave_uploadImg_category(@RequestParam("file") MultipartFile file,
                                                                 ProductModel productModel, CategoriaProdutoModel catpm) {
        try {
            productService.saveProduct_file_category(productModel, file, catpm);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("sucesso no upload", file.getOriginalFilename()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("Falha no upload de %s", file.getOriginalFilename()));
        }
    }

    @GetMapping
    public List<ProductModel> list() {

        return productService.listProduct();
    }

    private ImagemOfertaResponse testaMap(ImgProdutoModel imgModel) {
        long l1 = imgModel.getId();
        String download = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files").path(Long.toString(l1))
                .toUriString();
        ImagemOfertaResponse imgOferta = new ImagemOfertaResponse();
        imgOferta.setId(imgModel.getId());
        imgOferta.setName(imgModel.getName());
        imgOferta.setContentType(imgModel.getContentType());
        imgOferta.setSize(imgModel.getSize());
        imgOferta.setUrl(download);

        return imgOferta;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProduct(id);
        return HttpStatus.OK;
    }
}