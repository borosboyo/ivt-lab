package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore mockPrimaryTs;
  private TorpedoStore mockSecondaryTs;


  @BeforeEach
  public void init(){
    mockPrimaryTs = mock(TorpedoStore.class);
    mockSecondaryTs = mock(TorpedoStore.class);
    this.ship = new GT4500(mockPrimaryTs, mockSecondaryTs);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockPrimaryTs.fire(1)).thenReturn(true);
    when(mockSecondaryTs.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

  
    // Assert
    verify(mockPrimaryTs, times(1)).fire(1);
    //verify(mockSecondaryTs, times(1)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockPrimaryTs.fire(10)).thenReturn(true);
    when(mockSecondaryTs.fire(10)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockPrimaryTs, times(1)).fire(10);
    verify(mockSecondaryTs, times(1)).fire(10);
    assertEquals(true, result);
  }

}
