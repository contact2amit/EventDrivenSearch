package com.cliq.sample.productsender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cliq.sample.product.Product;

@RestController
@EnableBinding(Source.class)
@RequestMapping(path = "/product")
public class ProductDetailSender {
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailSenderApplication.class);
	
	@Autowired
	private Source source;
     
    @PostMapping(path= "/", consumes = "application/json")
    public BodyBuilder addProduct(@RequestBody Product product)  throws Exception 
                 
    {    
    	logger.info(product.toString());
    	this.source.output().send(MessageBuilder.withPayload(product).build());
        return ResponseEntity.status(HttpStatus.CREATED);
    }
    @PutMapping(path= "/", consumes = "application/json")
    public BodyBuilder updateProduct(@RequestBody Product product)  throws Exception 
                 
    {       
    	this.source.output().send(MessageBuilder.withPayload(product).build());
        return ResponseEntity.status(HttpStatus.ACCEPTED);
    }
}
