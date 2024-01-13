package com.app.notification.Model;

import lombok.*;

public record Email(String toEmail, String message, String title){}
