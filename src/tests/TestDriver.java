package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestDriver
{

    public static void main(String[] args)
    {
        Result transcriberReseults = JUnitCore
                .runClasses(TranscriberTest.class);

        for (Failure fail : transcriberReseults.getFailures())
        {
            System.out.println(fail.toString());
        }

        System.out.println(transcriberReseults.wasSuccessful());

    }

}
