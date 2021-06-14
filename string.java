import java.util.*; 
import java.io.*;

class Main {

  public static String MinWindowSubstring(String[] strArr) {
    int i,j,point=0,num=0,check=0,p=0;
    char let[] = new char[strArr[1].length()];
    char answer[]= new char[strArr[0].length()];
    int numbers[] = new int[strArr[0].length()-strArr[1].length()+1];
    String answers[] = new String[strArr[0].length()-strArr[1].length()+1];
    
    for(int k=0;k<strArr[0].length()-strArr[1].length()+1;k++) 
    {
      point=0;
      num=0;
      for(i=0;i<strArr[1].length();i++)
      {
        let[i]=strArr[1].charAt(i);
      }

      for(i=k;i<strArr[0].length();i++)
      {
        p=0;
        check=0;

        for(j=0;j<strArr[1].length();j++)
        {
          if(strArr[0].charAt(i)==let[j])
          {
            answer[point]=strArr[0].charAt(i);
            point++;
            let[j]= '\0';
            num++;
            check=1;
            break;
          }
        }

        for(int l=0;l<strArr[1].length();l++)
        {
          if(let[l]!='\0')
            p++;
        }

        if(p==0)
          break;

        if(check==0){
          answer[point]=strArr[0].charAt(i);
          point++;
          num++;
        }
      }
      if(p==0)
      {
      answers[k] = String.valueOf(answer);
      numbers[k]=num;
      }
      for(i=0;i<strArr[0].length();i++)
      {
        answer[i]='\0';
      }
    }
    int small=0;

    for(i=0;i<strArr[0].length()-strArr[1].length()+1;i++)
    {
      
      if(numbers[small]>numbers[i] && numbers[i]>1)
      {
        small=i;
      }
    }


    return answers[small];
  }


  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    String first,second;
    first=s.nextLine();
    second=s.nextLine();
    String hel[]= new String[2];
    hel[0]=first;
    hel[1]=second;
    System.out.print(MinWindowSubstring(hel)); 
  }

}