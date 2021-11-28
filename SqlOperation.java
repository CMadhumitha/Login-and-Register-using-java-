// TO INSERT DETAILS INTO A TABLE:

        String x1=jTextField1.getText();
        String x2=jTextField2.getText();
        try
        {
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","password");
            String sql="insert into login values('"+x1+"','"+x2+"')";
            Statement stm;
            stm=conn.createStatement();
            stm.executeUpdate(sql);
            setVisible(false);
            new Form1().setVisible(true);
        }
        catch( ClassNotFoundException | SQLException e)
        {

        }
// TO CHECK USERNAME AND PASSWORD:


        String x1=jTextField1.getText();
        String x2=jTextField2.getText();
        try
        {
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","password");
            String s="select * from login where uname='"+x1+"' and pwd='"+x2+"';";
            Statement stm=conn.createStatement();
            rs=stm.executeQuery(s);
            int count=0;
            while(rs.next())
            {
                count++;
            }
            if(count==1)
            {
                System.out.println("password matched");
                new Form3().setVisible(true);
            }
            else
            {
                System.out.println("wrong password");
            }
        }
        catch(ClassNotFoundException e)
        {

        }