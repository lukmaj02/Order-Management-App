package com.App.orderservice.dtos;

import lombok.Builder;

@Builder
public record Email(String toEmail, String message, String title){}

