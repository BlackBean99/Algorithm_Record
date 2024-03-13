package org.algorithm.미리내_코딩테스트;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        Solution solution = new Solution();
        String[] result = solution.solution(companies, applicants);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] companies, String[] applicants) {
        String[] answer = {};
        Map<String, Companies> companyMap = getCompanyMap(companies);
        Map<String, Applicants> applicantsMap = getApplicantsMap(applicants);
        Queue<String> rejected = new LinkedList<>();
        // key : 회사 // value : 지원자들
        Map<String, List<String>> accepted = new HashMap<>();
        // rejected초기화
        for (String s : applicants) {
            String[] split = s.split(" ");
            rejected.add(split[0]);
        }
        // accepted 초기화
        for (String s : companies) {
            String[] split = s.split(" ");
            accepted.put(split[0], new LinkedList<>());
        }
        for (int round = 0; round < companies.length; round++) {
            if (rejected.isEmpty()) {
                break;
            }
            // Key SEt
            for (String key : applicantsMap.keySet()) {
                Applicants applicant = applicantsMap.get(key);
                String[] preference = applicant.preference;
                String currentApplyCompany = preference[round];
                // 한 싸이클을 돌면 이걸 수행하면 안된다.
                if (round == 0) {
                    accepted.get(currentApplyCompany).add(key);
                }
            }
            // 반복되는 과정에서 rejected에 남아 있는 사람들은 해당 라운드에서 다시 지원시킨다.
            for (String key : rejected) {
                Applicants applicant = applicantsMap.get(key);
                String[] preference = applicant.preference;
                String currentApplyCompany = preference[round];
                if (round == 0) {
                    accepted.get(currentApplyCompany).add(key);
                }
            }
            if (round != 0) {
                for (String key : rejected) {
                    Applicants applicant = applicantsMap.get(key);
                    String[] preference = applicant.preference;
                    String currentApplyCompany = preference[round];
                    accepted.get(currentApplyCompany).add(key);
                }
            }
            // 다시 돌때는 기업의 count를 초기화 해줘야한다.
            for (String key : companyMap.keySet()) {
                Companies company = companyMap.get(key);
                company.count = Integer.parseInt(companies[0].split(" ")[2]);
            }
            // 라운드가 지날때마다 applicant count를 1씩 줄여준다.
            for (String key : applicantsMap.keySet()) {
                Applicants applicant = applicantsMap.get(key);
                int index = 0;
                for (int i = 0; i < applicants.length; i++) {
                    if (applicants[i].split(" ")[0].equals(key)) {
                        index = i;
                        break;
                    }
                }
                applicant.setCount(Integer.parseInt(applicants[index].split(" ")[2]) - round);
            }

            Set<String> lastRejected = new HashSet<>();
            // 2단계 : 기업은 채용 인원 수를 넘지 않는 한도 내에서 선호도가 높은 순서대로 지원자를 잠정 선택합니다.
            for (String key : accepted.keySet()) {
                List<String> list = accepted.get(key);
                Companies company = companyMap.get(key);
                int count = company.count;
                String[] preference = company.preference;
                LinkedList<String> tempAccepted = new LinkedList<>();
                for (int i = 0; i < preference.length; i++) {
                    if (round == companies.length - 1) {
                        break;
                    }
                    Applicants applicant = applicantsMap.get(preference[i]);
                    if (count == 0) {
                        continue;
                    }
                    if (applicant.count == 0) {
                        rejected.remove(preference[i]);
                        continue;
                    }
                    if (list.contains(preference[i])) {
                        // company count만큼만 받고 나머지는 reject
                        applicant.minusCount();
                        // abce 중 ce를 넣고 ab는 뺴야한다.
                        tempAccepted.add(preference[i]);
                        company.minusCount();
                        count--;
                        rejected.remove(preference[i]);
                    } else {
                        applicant.minusCount();
                    }
                }
                if (round > 0) {
                    for (String s : preference) {
                        if (applicantsMap.get(s).count > 0 && !isContainValue(accepted, s)) {
                            lastRejected.add(s);
                        }
                    }
                }
                if (tempAccepted.size() > 0) {
                    accepted.replace(key, tempAccepted);
                }
            }
            if (lastRejected.isEmpty()) {
                continue;
            }
            rejected.addAll(lastRejected);
            // 3단계 : 거절당한 지원자들 중에서 다른 기업에 지원할 지원자가 있다면 1단계부터 반복하고, 없다면 잠정 결정을 최종 매칭으로 결정한다.
        }

        answer = new String[accepted.size()];
        int index = 0;
        for (String key : accepted.keySet()) {
            List<String> list = accepted.get(key);
            StringBuilder sb = new StringBuilder();
            sb.append(key).append("_");
            list.sort(String::compareTo);
            for (String s : list) {
                sb.append(s);
            }
            // sb 오름차순으로 sort
            answer[index] = sb.toString();
            index++;
        }
        return answer;
    }

    private boolean isContainValue(Map<String, List<String>> accepted, String s) {
        for (String key : accepted.keySet()) {
            List<String> list = accepted.get(key);
            if (list.contains(s)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, Applicants> getApplicantsMap(String[] applicants) {
        Map<String, Applicants> applicantsMap = new HashMap<>();
        for (int i = 0; i < applicants.length; i++) {
            Applicants applicant = new Applicants();
            String[] s = applicants[i].split(" ");
            applicant.preference = s[1].split("");
            applicant.count = Integer.parseInt(s[2]);
            applicantsMap.put(s[0], applicant);
        }
        return applicantsMap;
    }

    private Map<String, Companies> getCompanyMap(String[] companies) {
        Map<String, Companies> companyMap = new HashMap<>();
        for (int i = 0; i < companies.length; i++) {
            Companies company = new Companies();
            String[] s = companies[i].split(" ");
            company.preference = s[1].split("");
            company.count = Integer.parseInt(s[2]);
            companyMap.put(s[0], company);
        }
        return companyMap;
    }

    class Companies {
        String[] preference;
        int count;

        public void minusCount() {
            this.count--;
        }
    }

    class Applicants {
        String[] preference;
        int count;

        public void minusCount() {
            this.count--;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
