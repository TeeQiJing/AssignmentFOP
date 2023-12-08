/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package codefornature;

/**
 *
 * @author GIGA
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class BBCNews {
    public static void UpdateNews() {

        try{
            Connection conn = JConnection.Conn();
            String deleteSql = "DELETE FROM news";
            PreparedStatement statement = conn.prepareStatement(deleteSql);
            statement.executeUpdate();
            
            int pages = 10;
            int count = 0;
            
            String str = "";
            String urls[] = new String[pages];
            
            for(int i=0; i<pages; i++)
                urls[i] = "https://www.bbc.com/news/topics/cnx753jenyjt?page=" + (i+1);        
            
            for(String url : urls){     
                Document document = Jsoup.connect(url).get();
                Elements div = document.select("div.ssrcss-d9gbsd-Promo.e1vyq2e80 div.ssrcss-1ns4t85-PromoSwitchLayoutAtBreakpoints.et5qctl0 div.ssrcss-tq7xfh-PromoContent.exn3ah99");

                for(Element row : div){    
                    String title = row.select("p.ssrcss-17zglt8-PromoHeadline.exn3ah96 span").text();
                    String newsUrl="https://bbc.com" + row.select("a.ssrcss-1mrs5ns-PromoLink.exn3ah91[href]").attr("href");
                    String newsDate = row.select("div.ssrcss-13nu8ri-GroupChildrenForWrapping.eh44mf02 span.visually-hidden.ssrcss-1f39n02-VisuallyHidden.e16en2lz0").text();
                    
                    newsDate = NewsDate.DateFormatter(newsDate);
                         
                    if(newsDate.equals(""))
                        continue;
                    else{         
                        // Parse the string to java.util.Date
                        Date parsedDate = NewsDate.parseDateString(newsDate);

                        // Convert java.util.Date to java.sql.Date
                        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                        
                        String sql = "INSERT INTO news(title, url, date) VALUES (?,?,?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, title);
                        stmt.setString(2, newsUrl);
                        stmt.setDate(3, sqlDate);
                        
                        stmt.executeUpdate();

                        System.out.println(title + "\n" + newsUrl + "\n" + newsDate + "\n");

                        str = str + (title + "\n" + newsUrl + "\n" + newsDate + "\n\n");    
                        count++;
                    }     
                } 
            }
            
            FileWriter fw = new FileWriter("NewsSample.txt"); 

            // read each character from string and write 
            // into FileWriter 
            for (int i = 0; i < str.length(); i++) 
                fw.write(str.charAt(i)); 

            System.out.println("Successfully written. Total " + count + " News."); 
            
            // close the file 
            fw.close();        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
