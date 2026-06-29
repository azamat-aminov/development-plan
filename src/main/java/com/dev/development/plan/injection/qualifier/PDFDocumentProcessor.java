package com.dev.development.plan.injection.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
//@Primary
@Qualifier("pdfDocumentProcessor")
public class PDFDocumentProcessor implements DocumentProcessor {

  @Override
  public void processDocument() {

  }
}
