package com.dev.development.plan.injection.qualifier;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

  private final DocumentProcessor documentProcessor;

  private final List<DocumentProcessor> documentProcessors;

  public DocumentController(
      @Qualifier("pdfDocumentProcessor") DocumentProcessor documentProcessor,
      List<DocumentProcessor> documentProcessors) {
    this.documentProcessor = documentProcessor;
    this.documentProcessors = documentProcessors;
  }

  //implement the endpoints
}
