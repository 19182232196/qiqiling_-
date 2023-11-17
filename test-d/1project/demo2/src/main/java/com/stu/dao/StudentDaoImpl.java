package com.stu.dao;

import com.stu.bean.Person;
import com.stu.bean.StudentAnswer;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    //获取所有教师
    @Override
   //获取所有教师
    public List<Person> getAllTeacher() {
        //查询语句，查询userIdentify为1的person表中的所有数据
        String sql = "select * from person where userIdentify=1";
        //调用Deal类的getAllPerson方法，传入sql语句，返回查询结果
        return Deal.getAllPerson(sql);
    }
    //根据搜索文本搜索教师
    @Override
   //根据输入的文本搜索教师
    public List<Person> getSearchTeacher(String matchText) {
        //构建查询语句
        String sql = "SELECT * FROM person WHERE userIdentify=1 AND (userAccount='"+matchText+"' OR userName LIKE'%"+matchText+"%' OR userOtherName LIKE'%"+matchText+"%')";
        //返回查询结果
        return Deal.getAllPerson(sql);
    }

    //根据用户账号获取教师
    @Override
   //根据用户账号获取教师列表
    public List<Person> getMyTeacher(String userAccount) {
        //根据用户账号查询教师表
        String sql = "SELECT * FROM person WHERE userAccount IN (SELECT `teacherAccount` AS userAccount FROM userteacher ut WHERE ut.`userAccount`='"+userAccount+"')";
        //返回查询结果
        return Deal.getAllPerson(sql);
    }

    //添加教师
    @Override
   //向userteacher表中插入用户账号和教师账号
    public void addTeacher(String userAccount, String teacherAccount) {
        String sql = "insert into userteacher values('"+userAccount+"','"+teacherAccount+"')";
        Deal.deal(sql);
    }
    //获取教师任务
    @Override
   //根据用户账号和教师账号查询学生任务
    public List<StudentAnswer> goMyTeaTask(String userAccount, String teacherAccount) {
        //查询学生任务表中符合用户账号和教师账号的记录
        String sql = "SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE (s.`studentAccount`='"+userAccount+"' AND t.`teacherAccount`='"+teacherAccount+"')";
        //返回查询结果
        return Deal.getTaskDetail(sql);
    }

    //删除教师
    @Override
   //根据用户账号和教师账号删除教师
    public void deleteMyTeacher(String userAccount, String teacherAccount) {
        //根据用户账号和教师账号删除userteacher表中的记录
        String sql = "DELETE FROM `userteacher` WHERE `userAccount`='"+userAccount+"' AND `teacherAccount`='"+teacherAccount+"'";
        Deal.deal(sql);
        //根据教师账号删除studenttask表中的记录
        sql = "DELETE FROM `studenttask` WHERE `taskAccount` IN(SELECT `taskAccount` FROM `task` WHERE `teacherAccount`='"+teacherAccount+"') AND studentAccount='"+userAccount+"'";
        Deal.deal(sql);
    }

    //完成任务
    @Override
   // 根据用户账号、任务账号和答案，更新学生任务表中的学生答案和是否完成状态
    public void doAnswer(String userAccount, String taskAccount, String answer) {
        String sql = "UPDATE studenttask SET `studentAnswer`='"+answer+"',`isFinish`=1 WHERE `taskAccount`='"+taskAccount+"' AND `studentAccount`='"+userAccount+"'";
        Deal.deal(sql);
    }

    //处理分数
    @Override
   //更新任务分数
    public void dealFenshu(String taskAccount, String studentAccount, String fenshu) {
        //根据任务账号、学生账号和分数更新任务分数
        String sql = "UPDATE studenttask SET `isScore`='"+fenshu+"',`isFinish`=2 WHERE `taskAccount`='"+taskAccount+"' AND `studentAccount`='"+studentAccount+"'";
        Deal.deal(sql);
    }
}
