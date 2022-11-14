package com.tcc.fundatec.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private String error;
    private String message;
    private String path;
    private Integer status;
    private Date timestamp;
    private List<String> errors;

    @Override
    public String toString() {
        String errors = String.join("\n\t", this.errors);
        StringBuilder sb = new StringBuilder("Error Message:\n");
        sb.append("error => ").append(this.error).append("\n");
        sb.append("message => ").append(this.message).append("\n");
        sb.append("path => ").append(this.path).append("\n");
        sb.append("status => ").append(this.status).append("\n");
        sb.append("timestamp => ").append(this.timestamp).append("\n");
        sb.append("errors:\n\t").append(errors).append("\n");

        return sb.toString();
    }
}
