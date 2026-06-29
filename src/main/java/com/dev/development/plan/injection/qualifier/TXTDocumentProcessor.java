package com.dev.development.plan.injection.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("txtDocumentProcessor")
public class TXTDocumentProcessor implements DocumentProcessor {

  @Override
  public void processDocument() {

  }
}
