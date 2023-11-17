package com.stu.dao;

import com.stu.bean.StudentAnswer;
import com.stu.bean.Task;

import java.util.List;

//根据教师账号查询所有学生
public class TeacherDaoImpl implements TeacherDao {
    @Override
    public List AllStudentsByTeacherAccount(String userAccount) {
        //根据教师账号查询所有学生
        String sql = "SELECT * FROM `person` WHERE userAccount IN(SELECT userAccount FROM `userteacher` WHERE teacherAccount='"+userAccount+"')";
        return Deal.getAllPerson(sql);
    }
    @Override
    public List<Task> getAllMyTask(String userAccount) {
        //根据教师账号查询所有任务
        String sql = "SELECT * FROM task WHERE teacherAccount = '"+userAccount+"'";
        return Deal.getAllMyTask(sql);
    }
    @Override
    public List<StudentAnswer> getTaskDetail(String taskAccount) {
        //根据任务账号查询任务详情
        String sql ="SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE s.`taskAccount`='"+taskAccount+"'";
        return Deal.getTaskDetail(sql);
    }
   @Override
    public void AddTask(Task task) {
        // 向任务表中插入任务信息
        String sql = "INSERT INTO task VALUES('"+task.getTaskAccount()+"','"+task.getTeacherAccount()+"','"+task.getTaskDate()+"','"+task.getTaskName()+"')";
        Deal.deal(sql);
        // 向学生任务表中插入任务信息
        sql= "INSERT INTO `studenttask`(`taskAccount`,`studentAccount`,`studentAnswer`,`isFinish`,`isScore`) SELECT '"+task.getTaskAccount()+"',B.C,NULL,0,0 FROM (SELECT `userAccount` C FROM `userteacher` WHERE `teacherAccount`='"+task.getTeacherAccount()+"') AS B";
        Deal.deal(sql);
    }
    @Override
    public List getSearchStudentByTeacherAccount(String  userAccount,String matchText) {
        //根据教师账号和搜索文本查询学生
        String sql = "SELECT * FROM person WHERE userAccount IN (SELECT `userAccount` FROM `userteacher` WHERE `teacherAccount`='"+userAccount+"') AND (`userAccount`='"+matchText+"' OR `userName` LIKE'%"+matchText+"%' OR `userIdCard` ='"+matchText+"')";
        return Deal.getAllPerson(sql);
    }
    @Override
    public List<StudentAnswer> goStudentTaskDetail(String userAccount, String studentAccount) {
        //根据教师账号和学生账号查询学生任务详情
        String sql ="SELECT s.*,p.`userName`,`taskName` FROM `studenttask` s  INNER JOIN person p ON " +
                "s.`studentAccount`=p.`userAccount` INNER JOIN task t ON s.`taskAccount`=t.taskAccount WHERE (s.`studentAccount`='"+studentAccount+"' AND t.`teacherAccount`='"+userAccount+"')";
        return Deal.getTaskDetail(sql);
    }
    @Override
    public void deleteTask(String taskAccount,String studentAccount, String isFinish) {
        //根据任务账号、学生账号和是否完成状态删除任务
        if(Integer.parseInt(isFinish)==0){
            //直接删除
            String sql = "DELETE FROM studenttask WHERE taskAccount ='"+taskAccount+"' AND studentAccount = '"+studentAccount+"'";
            Deal.deal(sql);
        }
    }
    @Override
    public void deleteThisTask(String taskAccount) {
        //根据任务账号删除任务
        String sql = "DELETE FROM task WHERE taskAccount='"+taskAccount+"'";
        Deal.deal(sql);
        sql = "DELETE FROM studenttask WHERE taskAccount='"+taskAccount+"'";
        Deal.deal(sql);
    }
    @Override
    public void deleteThisPersonByTeacher(String studentAccount, String userAccount) {
        //根据学生账号和教师账号删除该学生
        String sql = "DELETE FROM `userteacher` WHERE `userAccount`='"+studentAccount+"' AND `teacherAccount`='"+userAccount+"'";
        Deal.deal(sql);
        sql = "DELETE FROM `studenttask` WHERE `taskAccount` IN(SELECT `taskAccount` FROM `task` WHERE `teacherAccount`='"+userAccount+"') AND studentAccount='"+studentAccount+"'";
        Deal.deal(sql);
    }
}