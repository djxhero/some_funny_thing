package com.djxhero.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExportCommonService {
    void setExportHeader(HttpServletRequest request, HttpServletResponse response,
                         String fileName);
}
