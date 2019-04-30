package com.djxhero.service;

import java.io.File;
import java.io.InputStream;

public interface QiNiuService {
    String upload(InputStream inputStream, String fileKeyName);

    String uploadFile(File file, String fileKeyName);
}
