package next.model;

import java.util.Date;

public class Answer {
	private long answerId;
	private String writer;
	private String contents;
	private Date createdDate;
	private long questionId;
	private int countOfAnswer;
	
	public Answer(String writer,String contents,long questionId) {
		this(0,writer,contents,new Date(),0);
	}
	public Answer(long answerId,String writer,String contents,Date createdDate,long questionId) {
		this.answerId=answerId;
		this.writer =writer;
		this.contents =contents;
		this.createdDate =createdDate;
		this.questionId = questionId;
	}
	
	public long getAnswerId() {
		return questionId;
	}
	public String getWriter() {
		return writer;
	}
	public String getContents() {
		return contents;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	public long getTimeFromCreatedDate() {
		return this.createdDate.getTime();
	}
	public long getquestionId() {
		return questionId;
	}
	public int getCountOfAnswer() {
		return countOfAnswer;
	}
	public void setCountOfAnswer(int count) {
		this.countOfAnswer = count;
	}
	@Override
	public int hashCode() {
		final int  prime =31;
		int result =1;
		
		result = prime *result +(int)(answerId^(answerId>>>32));
		return result;
	}
	public void update(Answer newAnswer) {
		this.contents = newAnswer.contents;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) 
			return true;
		if(obj==null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Answer other =(Answer) obj;
		if(answerId != other.answerId)
			return false;
		return true;
		
	}
	@Override
	public String toString() {
		return "Question [questionId="+questionId+
				",writer="+writer+
				",contents="+contents+
				",createdDate="+createdDate+
				",questionId="+questionId+"]";
	}
	
}
