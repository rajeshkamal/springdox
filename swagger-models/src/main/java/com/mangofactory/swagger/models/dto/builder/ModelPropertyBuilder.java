package com.mangofactory.swagger.models.dto.builder;

import com.mangofactory.swagger.models.dto.AllowableValues;
import com.mangofactory.swagger.models.dto.ModelProperty;
import com.mangofactory.swagger.models.dto.ModelRef;

public class ModelPropertyBuilder {
  private String type;
  private String qualifiedType;
  private int position;
  private Boolean required;
  private String description;
  private AllowableValues allowableValues;
  private ModelRef items;
  private Boolean uniqueItems = null;

  public ModelPropertyBuilder type(String type) {
    this.type = type;
    maybeTreatAsASet(type);
    return this;
  }

  private void maybeTreatAsASet(String type) {
    if ("set".equalsIgnoreCase(type)) {
      this.uniqueItems = true;
      this.type = "array";
    }
  }

  public ModelPropertyBuilder qualifiedType(String qualifiedType) {
    this.qualifiedType = qualifiedType;
    return this;
  }

  public ModelPropertyBuilder position(int position) {
    this.position = position;
    return this;
  }

  public ModelPropertyBuilder required(Boolean required) {
    this.required = required;
    return this;
  }

  public ModelPropertyBuilder description(String description) {
    this.description = description;
    return this;
  }

  public ModelPropertyBuilder allowableValues(AllowableValues allowableValues) {
    this.allowableValues = allowableValues;
    return this;
  }

  public ModelPropertyBuilder items(ModelRef items) {
    this.items = items;
    return this;
  }

  public ModelProperty build() {
    return new ModelProperty(type, qualifiedType, position, required, description, allowableValues, items, uniqueItems);
  }
}