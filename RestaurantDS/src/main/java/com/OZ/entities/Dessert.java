package com.OZ.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("Dessert")

public class Dessert extends Met{

}
