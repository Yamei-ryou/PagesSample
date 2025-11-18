
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Omikuji")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        int rand = (int)(Math.random() * 6);
        if (rand == 4 || rand == 5) {
            rand = 0;
        }

        String result = "";
        String message = "";
        String image = "";

        if (rand == 0) {
            result = "くるしゅうない（大吉殿）";
            message = "今日は精一杯やりたいことやるぜ！";
            image = "dai_kichi.png";
        } else if (rand == 1) {
            result = "中吉でございます";
            message = "ランチにステーキ食べて元気だそうぜ！";
            image = "chu_kichi.png";
        } else if (rand == 2) {
            result = "小吉だべ";
            message = "階段でコケないように注意しよう";
            image = "sho_kichi.png";
        } else {
            result = "凶凶凶凶凶";
            message = "可哀想に…";
            image = "kawaisouni.png";
        }

        out.println("<html><head><meta charset='UTF-8'><title>結果</title></head>");
        out.println("<body style='text-align:center; font-size:26px; padding-top:50px;'>");
        out.println("<h2>🐱 おみくじ結果発表 🐱</h2>");
        out.println("<h1>" + result + "</h1>");
        out.println("<p>" + message + "</p>");
        out.println("<img src='img/" + image + "' style='width:200px;'>");
        out.println("<br><br><a href='index.html'>戻る</a>");
        out.println("</body></html>");
    }
}
