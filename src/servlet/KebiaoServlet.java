package servlet;

import com.google.gson.Gson;
import spidertools.GetData;
import spidertools.Kebiao;

import javax.servlet.annotation.WebServlet;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/KebiaoServlet")
public class KebiaoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // response.setContentType("application/json");
        response.setContentType("text/html;charset=UTF-8");

        Gson gson = new Gson();

        String stuID = request.getParameter("number");
//        String stuID = "2017210246";
        if (stuID == null) {
            response.getWriter().printf("???");
        }
        ArrayList<String> classnum = GetData.getClassNum(stuID);
        ArrayList<String> classify = GetData.getclassification(stuID);
        ArrayList<String> type = GetData.getType(stuID);
        ArrayList<String> state = GetData.getStatus(stuID);
        Map<String, String> classname = GetData.getClassName(stuID);
        Map<String, String> classToteacher = GetData.getClassToTeacher(stuID);
        Map<String, ArrayList<String>> time = GetData.getSchedule(stuID);
        Map<String, ArrayList<String>> place = GetData.getPlace(stuID);
        ArrayList<Kebiao> kebiao = new ArrayList<>();
        String teacher;
        int size;
        if (classnum.size() > 0) {
//            response.getWriter().printf(String.valueOf(classnum.size()));
            for (int i = 0; i < classnum.size(); i++) {

                Kebiao k = new Kebiao();

                teacher = classToteacher.get(classnum.get(i));
                k.setClassnum(classnum.get(i));

                k.setClassname(classname.get(classnum.get(i)));

                k.setState(state.get(i));
                k.setClassify(classify.get(i));
                k.setType(type.get(i));
//            response.getWriter().printf(classnum.get(i));
                k.setTeacher(teacher);

                size = time.get(teacher).size();    //获得时间的循环次数
//            response.getWriter().printf(String.valueOf(size));

                ArrayList<String> w = new ArrayList<>();
                ArrayList<String> p = new ArrayList<>();
                ArrayList<String> ws = new ArrayList<>();
                ArrayList<String> t = new ArrayList<>();
                if (time.get(teacher) != null && size > 0) {
//                response.getWriter().printf(String.valueOf(size));
                    for (int j = 0; j < size; j = j + 3) {
                        w.add(time.get(teacher).get(j));
                        ws.add(time.get(teacher).get(j + 2));
                        t.add(time.get(teacher).get(j + 1));
                    }

                } else {
                    response.getWriter().printf("error");
                }
                if (place.get(teacher) != null && place.get(teacher).size() > 0) {
                    for (int m = 0; m < place.get(teacher).size(); m++) {
                        p.add(place.get(teacher).get(m));
                    }
//                for(int j=0;j<p.size();j++){
//                response.getWriter().printf(p.get(j));
//            }
                    k.setWeek(w);
                    k.setTime(t);
                    k.setWeeks(ws);
                    k.setPlace(p);

                    kebiao.add(k);
                } else {
                    response.getWriter().printf("fail1");
                }
            }

        } else {
            response.getWriter().printf("fail2");
        }

        if (classnum.size() == 0 && classnum == null) {
            response.getWriter().printf("???");
        } else {
            String gkebiao = gson.toJson(kebiao);
//    response.getWriter().printf(gkebiao);
            request.setAttribute("gkebiao", gkebiao);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
