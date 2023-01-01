import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

public class YoutubeFilter {
    public static void main(String[] args) {

        // 1. 관리자 계정 생성 및 로그인 기능 구현, 로그인 실패시 경고문구와 함께 종료, 관리자계정과 비밀번호는 final 키워드로 선언
        // 2. 금칙어 대체어는 배열을 활용하여 정의
        // 3. '특정 문자열을 찾는 메서드'를 통해 금칙어를 확인하고, 존재한다면 '문자열 전환 메서드' 사용하여 바꿔 출력
        // 3.1. 금칙어는 하나씩 입력된 문장과 비교하고
        // 3.2. 존재하면 대체어로 변환하여 문자열에 새롭게 저장

        /*
        admin_id: 관리자 계정 id
        admin_pw: 관리자 계정 pw
        id: 입력 id
        pw: 입력 pw
        prohibit: 금지어 배열
        filter: 대체어 배열
        caption: 입력한 자막
        scanner: 스캐너 클래스 변수
         */


        final String admin_id = "admin";
        final String admin_pw = "0000";
        String id;
        String pw;
        String caption;
        Scanner scanner = new Scanner(System.in);

        // 1
        System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {EX - admin} : ");
        id = scanner.nextLine();
        System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요 {EX - 0000} : ");
        pw = scanner.nextLine();
        if(!(id.equals(admin_id)) || !(pw.equals(admin_pw))){ // id 와 pw 중 하나라도 다르면 if문 실행
            System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            exit(1);
        }

        // 2
        String[] prohibit = new String[]{ "킹", "시발", "꺼져", "미친" };
        String[] filter = new String[]{ "열", "사랑", "용기", "희망" };

        // 3
        System.out.println();
        System.out.println("[안내] 안녕하세요 admin님.");
        System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
        caption = scanner.nextLine();

        System.out.println("=".repeat(30));
        System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
        System.out.println(Arrays.toString(prohibit));
        System.out.println("=".repeat(30));

        System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
        for(int i =0;i < prohibit.length; i++){
            if( caption.indexOf(prohibit[i]) > -1 ) {
                caption = caption.replace(prohibit[i], filter[i]);
            }
        }
        System.out.println(">>> " + caption);
        System.out.println("[안내] 프로그램을 종료합니다.");

    }
}