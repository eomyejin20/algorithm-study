# 📚 Melting Studio Algorithm Study
코딩 테스트 실력 향상을 위한 알고리즘 스터디입니다.

---

# 👥 스터디 구성원

* 박상희(스터디 장)
* 남해림
* 엄예진

---

# 📅 스터디 진행 방식

* 매주 **일요일에 문제 출제**
* **금요일까지 문제 풀이**
* **토요일 ~ 일요일**

  * 커밋
  * Pull Request 생성
  * 코드 리뷰

PR 확인 후 **스터디 장이 Merge 진행**

---

# 🧩 문제 출제 방식

매주 총 **5문제**

* 브론즈 2
* 실버 2
* 골드 1

문제는 아래 위치에 업로드됩니다.

* GitHub **Issue**
* **Notion 알고리즘 코딩 스터디 페이지**

---

# ✅ 제출 규칙

* 매주 **최소 2문제 이상 풀이**
* 풀이 후 **commit → PR 생성**

---

# 🔧 Git 작업 방식

### 1️⃣ Repository Fork

스터디 Repository를 개인 GitHub로 **Fork**

### 2️⃣ Fork Repository Clone

로컬에서 작업

```bash
git clone https://github.com/본인아이디/algorithm-study.git
cd algorithm-study
```

---

### 3️⃣ Upstream 연결 (원본 repo와 연결)

```bash
git remote add upstream https://github.com/Melting-Studio-Study/algorithm-study.git
```

확인

```bash
git remote -v
```

---

### 4️⃣ 작업 전 Sync

작업 전 **반드시 최신 코드로 동기화**
- 개인 리포지토리 synk fork 후 git pull

또는  
```bash
git fetch upstream
git merge upstream/main
```

또는

```bash
git pull upstream main
```

---

### 5️⃣ 코드 작성 후 Commit

```bash
git add .
git commit -m "(#이슈번호)week01: BOJ 1920 수찾기"
git push origin main
```

---

### 6️⃣ Pull Request 생성

GitHub에서

```
본인 Fork Repo → Pull Request
```

생성

PR 확인 후 **스터디 장이 Merge 진행**

---

# ⚠️ Git 규칙

* 작업 전 **반드시 Sync Fork**
* 코드 수정 후 **Commit → PR**
* **다른 브랜치 생성 금지**
* **자신의 폴더만 수정**

수정 가능 폴더

```
본인이름 폴더 내부만 수정
```

---

# ✏️ 추가 활동

풀이한 문제는 아래 플랫폼에 정리 권장

* Velog
* Tistory
* Notion
* 개인 블로그

---

# 📁 Repository Structure

```text
algorithm-study
│
├─ README.md
│
├─ SANGHEE_PARK
│  ├─ week01
│  │  ├─ boj_1920_수찾기.java
│  │  └─ boj_10828_스택.java
│  │
│  ├─ week02
│  └─ week03
│
├─ HAERIM_NAM
│  └─ week01
│
└─ YEJIN_EUM
   └─ week01
```

---

# 📌 파일명 규칙

```
boj_문제번호_문제이름.언어
```

예

```
boj_1920_수찾기.java
boj_1010_다리놓기.py
```

---

# 📝 PR 작성 규칙

PR 생성 시 아래 형식으로 작성

### 예시

**1010 - 다리 놓기**

🤔 **접근 방법**

다른 사람 코드 / AI 활용 여부 [Y / N]

알고리즘
* 조합

설명
* 케이스 개수 T 입력
* 강 양쪽 사이트 개수 n, m 입력
* 조합 공식을 활용하여 계산


✏️ **구현 (핵심 코드)**

```java
for j in range(n):
    result *= m-j
    result /= j+1
```

✔️ **배운 점**

* 조합 공식에서 팩토리얼을 직접 계산하지 않고 효율적으로 계산하는 방법을 이해하게 되었다.

---
