package black.Junit;

import java.awt.Dimension;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import black.swing.StandardCalculator;

public class Frame_Test{

    private FrameFixture frame;
    
    @Before
    public void setUp() {
        Dimension dimension = new Dimension();
        dimension.setSize(500, 420);
        frame = new FrameFixture(new StandardCalculator()); 
        frame.show(dimension);
    }

    @After
    public void tearDown() {
        frame.cleanUp();
    }
    
    /**
     * button 1~9 test
     */
    @Test
    public void numberButtonTest() {
        String buttonName = "button";
        for (int i = 0; i <= 9; i++) {
            frame.button("button" + Integer.toString(i)).click();
            frame.label("numberLabel").requireText(Integer.toString(i));
            frame.button("buttonClear").click();
        }
    }
    
    /**
     * test point
     */
    @Test
    public void pointButtonTest() {
        frame.button("buttonPoint").click();
        frame.label("numberLabel").requireText("0.");
        frame.button("buttonClear").click();
        frame.label("numberLabel").requireText("0");    
    }
   
    /**
     * test operatedNumberLabel
     */
    @Test
    public void operatedNumberLabelTest() {
        frame.button("button1").click();
        frame.button("buttonAdd").click();
        frame.button("button2").click();
        frame.button("buttonAdd").click();
        frame.label("numberLabel").requireText("3");    
        frame.label("operatedNumberLabel").requireText("1 + 2 + ");
    }
    
    /**
     * test -
     */
    @Test
    public void subtractTest() {      
        frame.button("button1").click();
        frame.button("buttonSubtract").click();
        frame.button("button2").click();
        frame.button("buttonSubtract").click();
        frame.label("numberLabel").requireText("-1");    
        frame.label("operatedNumberLabel").requireText("1 - 2 - ");     
    }

    /**
     * test *
     */
    @Test
    public void multiplyTest() {      
        frame.button("button2").click();
        frame.button("buttonMultiply").click();
        frame.button("button3").click();
        frame.button("buttonMultiply").click();
        frame.label("numberLabel").requireText("6");    
        frame.label("operatedNumberLabel").requireText("2 * 3 * ");     
    }
    
    /**
     * test =
     */
    @Test
    public void equalTest() {      
        frame.button("button1").click();
        frame.button("buttonAdd").click();
        frame.button("button2").click();
        frame.button("buttonAdd").click();
        frame.button("button3").click();
        frame.button("buttonEqual").click();
        frame.label("numberLabel").requireText("6");
        frame.label("operatedNumberLabel").requireText(""); 
    }
    
    /**
     * test =
     */
    @Test
    public void mixTest() {            
        frame.button("button1").click();
        frame.button("buttonAdd").click();
        frame.button("button2").click();
        frame.button("buttonSubtract").click();
        frame.button("button3").click();
        frame.button("buttonEqual").click();
        frame.label("numberLabel").requireText("0");
        frame.label("operatedNumberLabel").requireText("");
        
        frame.button("buttonClear").click();
        
        frame.button("button1").click();
        frame.button("buttonAdd").click();
        frame.button("button5").click();
        frame.button("buttonSubtract").click();
        frame.button("button3").click();
        frame.button("buttonMultiply").click();
        frame.button("button3").click();
        frame.button("buttonEqual").click();
        frame.label("numberLabel").requireText("9");
        frame.label("operatedNumberLabel").requireText("");
    }
}
