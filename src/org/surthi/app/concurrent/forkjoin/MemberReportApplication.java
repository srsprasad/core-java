package org.surthi.app.concurrent.forkjoin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberReportApplication {
    private static String[][] data = new String[][]{
            {"Ravi", "07-07-1980", "10-01-2018"},
            {"Vyshu", "03-04-1989", "10-01-2018"},
            {"Geetha", "10-04-1976", "10-01-2018"},
            {"Mallika", "08-05-1982", "10-01-2018"},
            {"Sidramulu", "16-05-1951", "10-01-2018"},
            {"Balamani", "10-10-1956", "10-01-2018"},
            {"Jagadeesh", "10-04-1980", "10-01-2018"}
    };

    public static void main(String... args) throws Exception {
        MemberReportApplication app = new MemberReportApplication();
        List<MemberWrapper> memberWrappers = app.buildMemberWrappers();
        System.out.println("Number of Members: " + memberWrappers.size());
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(new MemberWork(memberWrappers, Calendar.getInstance().getTime()));
        System.out.println("Members: " + memberWrappers.toString());
    }

    public List<MemberWrapper> buildMemberWrappers() throws Exception {
        final List<MemberWrapper> memberWrappers = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        for (String[] dA : Stream.of(data).collect(Collectors.toList())) {
            final Member member = new Member(dA[0], format.parse(dA[1]), format.parse(dA[2]));
            memberWrappers.add(new MemberWrapper(member));
        }
        return memberWrappers;
    }
}

class MemberWork extends RecursiveAction {
    private final List<MemberWrapper> memberWrappers;
    private final Date currentDate;

    public MemberWork(final List<MemberWrapper> memberWrappers, final Date date) {
        this.memberWrappers = memberWrappers;
        this.currentDate = date;
    }

    @Override
    protected void compute() {
        if (memberWrappers.size() == 2) {
            evaluateMember(memberWrappers.get(0));
            evaluateMember(memberWrappers.get(1));
        } else if (memberWrappers.size() == 1) {
            evaluateMember(memberWrappers.get(0));
        } else {
            int middleIndex = memberWrappers.size() / 2;
            final List<MemberWrapper> leftMembers = new ArrayList<>();
            final List<MemberWrapper> rightMembers = new ArrayList<>();
            for (int index = 0; index < memberWrappers.size(); index++) {
                if (index < middleIndex)
                    leftMembers.add(memberWrappers.get(index));
                else
                    rightMembers.add(memberWrappers.get(index));
            }
            invokeAll(new MemberWork(leftMembers, currentDate), new MemberWork(rightMembers, currentDate));
        }
    }

    private void evaluateMember(final MemberWrapper memberWrapper) {
        long diff = currentDate.getTime() - memberWrapper.getMember().getRegisteredDate().getTime();
        long daysSinceRegistered = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        Calendar todaysCal = Calendar.getInstance();
        todaysCal.setTime(currentDate);
        Calendar dobCal = Calendar.getInstance();
        dobCal.setTime(memberWrapper.getMember().getDateOfBirth());
        int age = todaysCal.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);
        memberWrapper.setDaysSinceRegistered((int) daysSinceRegistered);
        memberWrapper.setAge(age);
    }
}