package com.cliq.sample.productprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import com.cliq.sample.product.Product;

@EnableBinding(Processor.class)
public class ProductUploadProcessor {


	private static final Logger logger = LoggerFactory.getLogger(ProductUploadProcessorApplication.class);

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Product processUsageCost(Product product) {
		Product usageCostDetail = product;
		logger.info(product.toString());
		return usageCostDetail;
	}
}
