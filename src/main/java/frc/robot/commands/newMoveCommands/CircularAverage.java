package frc.robot.commands.newMoveCommands;

import java.lang.reflect.Array;

public class CircularAverage {
  public double[] m_array;
  public int m_size;
  public boolean m_initialized;
  int m_entryPoint;

  public CircularAverage( int size ) {
    m_size = size;
    m_array = new double[size];
    m_initialized = false;
    m_entryPoint = 0;
  }

  public double Average( double newValue) {
    double sum;

    if (!m_initialized) {
      // This is one way to do the setup, it acts like
      // all earlier values were the same as newValue
      for (int i = 0;i < m_size; i++) {
        m_array[i] = newValue;
      }
      m_entryPoint = 0;
      m_initialized = true;
    }
    // slower version of average that avoids some roundoff errors
    m_array[m_entryPoint] = newValue;
    sum = 0;
    for (int i=0;i<m_size;i++){
      sum += m_array[i];
    }
    return sum / m_size;
  }


}
