package com.example.sampleapp1.overriden;

public class GST  extends IncomeTax{
    @Override
    public int calculateTax(int income) {
        int oldTax = super.calculateTax(income);
        int gst = oldTax + 15;
        return gst;
    }
}
