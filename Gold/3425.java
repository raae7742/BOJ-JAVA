import java.util.*;
import java.io.*;

public class Main {
    static final long MAX = 1000000000;

    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isQuitted = false;
        
        
        while (true) {
            List<Command> commands = new ArrayList<>();
            
            // program area
            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String comm = st.nextToken();

                if (comm.equals("QUIT")) {
                    br.close();
                    return;
                }
                if (comm.equals("END")) break;
                
                if (comm.equals("NUM")) {
                    long num = Long.parseLong(st.nextToken());
                    commands.add(new Command(comm, num));
                    continue;
                }
                
                commands.add(new Command(comm));
            }
            
            // input area
            int n = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < n; i++) {
                boolean isError = false;
                Stack<Long> stack = new Stack<>();

                long input = Long.parseLong(br.readLine());
                stack.push(input);
                
                for(Command c : commands) {
                    try {
                        if (c.comm.equals("NUM")) {
                            stack.push(c.num);
                        }
                        else if (c.comm.equals("POP")) {
                            stack.pop();
                        }
                        else if (c.comm.equals("INV")) {
                            long num = stack.pop();
                            stack.push(0 - num);
                        }
                        else if (c.comm.equals("DUP")) {
                            long num = stack.peek();
                            stack.push(num);
                        }
                        else if (c.comm.equals("SWP")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            stack.push(num1);
                            stack.push(num2);
                        }
                        else if (c.comm.equals("ADD")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            
                            long result = num2 + num1;
                            if (Math.abs(result) > MAX) {
                                isError = true;
                                break;
                            }
                            
                            stack.push(result);
                        }
                        else if (c.comm.equals("SUB")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            
                            long result = num2 - num1;
                            if (Math.abs(result) > MAX) {
                                isError = true;
                                break;
                            }
                            
                            stack.push(result);
                            
                        }
                        else if (c.comm.equals("MUL")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            
                            long result = num2 * num1;
                            if (Math.abs(result) > MAX) {
                                isError = true;
                                break;
                            }
                            
                            stack.push(result);
                        }
                        else if (c.comm.equals("DIV")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            
                            if (num1 == 0) {
                                isError = true;
                                break;
                            }
                            
                            int cnt = 0;
                            if (num1 < 0) {
                                num1 = Math.abs(num1);
                                cnt++;
                            }
                            
                            if (num2 < 0) {
                                num2 = Math.abs(num2);
                                cnt++;
                            }
                            
                            long result = num2 / num1;
                            if (cnt == 1) result = 0 - result;
                            
                            stack.push(result);
                        }
                        else if (c.comm.equals("MOD")) {
                            long num1 = stack.pop();
                            long num2 = stack.pop();
                            
                            if (num1 == 0) {
                                isError = true;
                                break;
                            }
                            
                            boolean isMinus = false;
                            if (num1 < 0) {
                                num1 = Math.abs(num1);
                            }
                            
                            if (num2 < 0) {
                                num2 = Math.abs(num2);
                                isMinus = true;
                            }
                            
                            long result = num2 % num1;
                            if (isMinus) result = 0 - result;
                            
                            stack.push(result);
                        }
                    } catch(Exception e) {
                        isError = true;
                        break;
                    }
                }
                
                if (isError || stack.size() != 1) {
                    System.out.println("ERROR");
                } else {
                    System.out.println(stack.pop());
                }
            }
            
            System.out.println();
            br.readLine();
        }
    }
    
    static class Command {
        String comm;
        long num = -1;
        
        public Command(String comm) {
            this.comm = comm;
        }
        
        public Command(String comm, long num) {
            this.comm = comm;
            this.num = num;
        }
    }
}
