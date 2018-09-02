package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTestSuite {

    @Test
    public void getCost() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //when
        BigDecimal bigDecimal = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(5.00), bigDecimal);
    }

    @Test
    public void getDescription() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //when
        String testString = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course", testString);
    }

    @Test
    public void testTaxiNetworkGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //when
        BigDecimal testValue = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(40), testValue);
    }

    @Test
    public void testTaxiNetworkGetDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        //when
        String testString = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network", testString);
    }

    @Test
    public void testUberGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        //when
        BigDecimal testValue = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(25), testValue);
    }

    @Test
    public void testUberDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new UberNetworkOrderDecorator(taxiOrder);
        //when
        String testString = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by Uber", testString);
    }

    @Test
    public void testMyTaxiGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        BigDecimal testValue = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(37), testValue);
    }

    @Test
    public void testMyTaxiDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        String testString = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by MyTaxi + child seat", testString);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new VipDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        BigDecimal testValue = taxiOrder.getCost();
        //then
        assertEquals(new BigDecimal(52), testValue);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder = new VipDecorator(taxiOrder);
        taxiOrder = new ChildSeatDecorator(taxiOrder);
        //when
        String testString = taxiOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network + variant VIP + child seat", testString);
    }

}