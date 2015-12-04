// edfile.java
// Template for a line-oriented text editor inspired by ed.

import java.util.Scanner;

import static java.lang.System.*;
  java.io.*;

class edfile{

   public static void main (String[] args) throws IOException {
      boolean want_echo = true;
      dllist lines = new dllist();
      dllist thingy = new dllist();
      auxlib.STUB ("Check for -e option");
      auxlib.STUB ("Load file from args filename, if any.");
      try {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		while(true){
			String line = reader.readLine();
			if(line == null) 
				break;
			lines.insert(line, lines.getFollowing());
			System.out.println(lines.getItem());
			//System.out.println(line);
		}
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
      Scanner stdin = new Scanner (in);
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) continue;
         char command = inputline.charAt(0);
         switch (command) {
            case '#': break;
            case '$': lines.setPosition(lines.getLast()); break;
            case '*': lines.setPosition(lines.getLast()); break;
            case '.': System.out.println(lines.getItem());; break;
            case '0': lines.setPosition(lines.getFirst());
            System.out.println(lines.getItem());break;
            case '<': lines.setPosition(lines.getPrevious()); 
            System.out.println(lines.getItem());break;
            case '>': lines.setPosition(lines.getFollowing());
            System.out.println(lines.getItem()); break;
            case 'a': lines.insert(inputline.substring(2), lines.getFollowing()); break;
            case 'd': lines.delete(); break;
            case 'i': lines.insert(inputline.substring(2), lines.getPrevious()); break;
            case 'r': auxlib.STUB ("Call r command function."); break;
            case 'w': auxlib.STUB ("Call w command function."); break;
            default : auxlib.STUB ("Print invalid command."); break;
         }
      }
      auxlib.STUB ("(eof)");
   }

}

