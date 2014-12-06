package Game;

import java.util.*;

public class FullInventoryException extends Exception
{
      public FullInventoryException() {}

      public FullInventoryException(String message)
      {
         super(message);
      }
 }