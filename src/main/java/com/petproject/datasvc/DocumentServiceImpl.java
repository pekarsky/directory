package com.petproject.datasvc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DocumentServiceImpl implements DocumentService {
    private static Logger LOGGER = LogManager.getLogger(DocumentServiceImpl.class);
    public DocumentServiceImpl(){
        LOGGER.debug("Default contructor run");
    }
}
