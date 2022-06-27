/****** Script for SelectTopNRows command from SSMS  ******/
SELECT [StudentID]
      ,[Session].[SessionID]
	  ,[Session].[GroupID]
      ,[Attendance]
  FROM [PRJ_Assignment_1].[dbo].[Attendance] 
  inner join [Session] on Attendance.SessionID = [Session].SessionID
  inner join [Group] on [Session].GroupID = [Group].GroupID
  where [Group].GroupID = 'CEA201SU2201' order by Attendance.SessionID

  update Attendance Set Attendance = 0 where Attendance = 1