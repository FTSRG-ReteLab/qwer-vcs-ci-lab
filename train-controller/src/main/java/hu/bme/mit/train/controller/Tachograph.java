package hu.bme.mit.train.controller;

import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class Tachograph {

  private Table<Integer, Double, Double> t;

  public Tachograph() {
    t = HashBasedTable.create();
  }

  public void put(int timestamp, double jstick, double r_speed) {
    this.t.put(timestamp, jstick, r_speed);
  }

  public double get(int timestamp, double jstick) {
    return this.t.get(timestamp, jstick);
  }
}
