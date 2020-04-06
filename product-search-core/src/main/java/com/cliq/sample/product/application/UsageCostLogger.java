package com.cliq.sample.product.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.cliq.sample.product.Product;

@EnableBinding(Sink.class)
public class UsageCostLogger {

	private static final Logger logger = LoggerFactory.getLogger(ProductSearchApplication.class);

	@StreamListener(Sink.INPUT)
	public void process(Product usageCostDetail) {
		logger.info(usageCostDetail.toString());
	}
}