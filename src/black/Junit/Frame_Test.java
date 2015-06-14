package black.Junit;

import java.awt.Dimension;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import black.swing.CreateWindowNew;

public class Frame_Test{

    private FrameFixture frame;
    
    @Before
    public void setUp() {
        Dimension dimension = new Dimension();
        dimension.setSize(500, 420);
        frame = new FrameFixture(new CreateWindowNew()); 
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
}
