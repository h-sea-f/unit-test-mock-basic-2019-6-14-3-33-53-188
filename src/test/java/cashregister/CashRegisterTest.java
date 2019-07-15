package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //given
        Printer printer = new Printer();
        Purchase mockPurchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(mockPurchase.asString()).thenReturn("real purchase");
        //when
        cashRegister.process(mockPurchase);
        //then
        Assertions.assertEquals(outContent.toString(), "real purchase\n");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //given
        Printer printer = new Printer();
        Purchase mockPurchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(mockPurchase.asString()).thenReturn("stub purchase");
        //when
        cashRegister.process(mockPurchase);
        //then
        Assertions.assertEquals(outContent.toString(), "stub purchase\n");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = new Printer();
        Purchase mockPurchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        when(mockPurchase.asString()).thenReturn("stub purchase");
        //when
        cashRegister.process(mockPurchase);
        //then
        verify(mockPurchase).asString();
    }

}
