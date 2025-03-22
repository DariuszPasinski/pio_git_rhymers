package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

    public static final int TEST_ITERATIONS = 15;
    public static final int NUM_STANDARD_RHYMERS = 3;
    public static final int BOUND = 20;

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < TEST_ITERATIONS; i++)
            for (int j = 0; j < NUM_STANDARD_RHYMERS; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < TEST_ITERATIONS; i++)
            rhymers[NUM_STANDARD_RHYMERS].countIn(rn.nextInt(BOUND));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[NUM_STANDARD_RHYMERS]).reportRejected());
        
    }
    
}