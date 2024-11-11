package ooo.jtc.dictionaries.swift.bicplusv1;

import java.lang.String;
import java.util.List;

public final class BicPlusV1XmlBuilder {
  private String product;

  private String filetype;

  private String filedate;

  private List<BicPlusV1Node> bicPlusV1NodeList;

  public BicPlusV1XmlBuilder setProduct(String product) {
    this.product = product;
    return this;
  }

  public BicPlusV1XmlBuilder setFiletype(String filetype) {
    this.filetype = filetype;
    return this;
  }

  public BicPlusV1XmlBuilder setFiledate(String filedate) {
    this.filedate = filedate;
    return this;
  }

  public BicPlusV1XmlBuilder setBicPlusV1NodeList(List<BicPlusV1Node> bicPlusV1NodeList) {
    this.bicPlusV1NodeList = bicPlusV1NodeList;
    return this;
  }

  public BicPlusV1Xml create() {
    return new BicPlusV1Xml(product, filetype, filedate, bicPlusV1NodeList);
  }

  public static BicPlusV1XmlBuilder builder() {
    return new BicPlusV1XmlBuilder();
  }
}
