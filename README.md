##سلااام


مثل تمام Readme ها توی پروژه های قبلیم اول میام و دو تا از مهم ترین کلاس هایی که توی پروژه زدم رو کامل توضیح میدم


(همه‌ی کلاس ها مهمن ولی خب من از اونا که بیشتر پایه رو تشکیل میدن شروع میکنم)


و بعد کد رو به صورت کلی توضیح میدم و نهایت هم خروجی رو براتون میزارم


قبل از اینکه بخواید شروع کنید به خوندن بعضی جاهای متنم به تلاش های بی نتیجم برا زیبا تر کردن و مرتب تر کردن این متنم برمی‌خورید که خیلی تلاش کرد درستشون کنم و نشد ... مثل (java Copy) 



برا همین پاکشون هم نکردم که ببینید تلاشمو کردم ... 😔🙄🙄



##اول از کلاس Book:

public class Book {

    private final String title;
    private final int pageCount;

    public Book(String title, int pageCount) throws IllegalArgumentException {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }

        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (pageCount <= 0) {
            throw new IllegalArgumentException("Page count must be positive");
        }

        this.title = title.trim();
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return String.format("%s (%d pages)", title, pageCount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Book other = (Book) obj;
        return pageCount == other.pageCount &&
                title.equals(other.title);
    }

    @Override
    public int hashCode() {
        return 31 * title.hashCode() + pageCount;
    }
}



##توضیحات مربوطه :   





📖 معرفی کلاس Book


کلاس Book یک مدل ساده برای نمایش اطلاعات کتاب در سیستم مدیریت کتابخانه است. این کلاس ویژگی‌های اصلی یک کتاب و اعتبارسنجی‌های لازم را پیاده‌سازی می‌کند.


✨ ویژگی‌های کلیدی


Immutability: شیء کتاب پس از ایجاد غیرقابل تغییر است


Validation: اعتبارسنجی خودکار فیلدها هنگام ساخت


Standard Methods: پیاده‌سازی استاندارد toString، equals و hashCode




🏗️ ساختار کلاس



فیلدها





java


Copy


private final String title;    // عنوان کتاب (غیرقابل تغییر)


private final int pageCount;  // تعداد صفحات (غیرقابل تغییر)





سازنده (Constructor)



java
Copy
public Book(String title, int pageCount) throws IllegalArgumentException





پارامترها:



title: عنوان کتاب (نباید null یا خالی باشد)


pageCount: تعداد صفحات (باید بزرگتر از ۰ باشد)




خطاهای ممکن:




IllegalArgumentException با پیام "Title cannot be null"


IllegalArgumentException با پیام "Title cannot be empty"


IllegalArgumentException با پیام "Page count must be positive"




متدهای اصلی

1. دریافت عنوان کتاب

java
Copy
public String getTitle()


برگشت‌دهنده: عنوان کتاب


2. دریافت تعداد صفحات

java
Copy
public int getPageCount()


برگشت‌دهنده: تعداد صفحات کتاب


3. نمایش رشته‌ای کتاب

java
Copy
@Override
public String toString()


فرمت خروجی:


عنوان کتاب (تعداد صفحات pages)


مثال: "Java Programming (300 pages)"



4. مقایسه کتاب‌ها

java
Copy
@Override
public boolean equals(Object obj)


دو کتاب برابرند اگر هم عنوان و هم تعداد صفحات یکسان داشته باشند


5. تولید hashCode

java
Copy
@Override
public int hashCode()


تولید hashCode بر اساس عنوان و تعداد صفحات


🧪 نمونه استفاده



ایجاد کتاب

java
Copy
try {
    Book book1 = new Book("Effective Java", 416);
    Book book2 = new Book("", 200); // خطا: Title cannot be empty
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}


استفاده از متدها

java
Copy
Book book = new Book("Clean Code", 464);

System.out.println(book.getTitle());    // "Clean Code"
System.out.println(book.getPageCount()); // 464
System.out.println(book.toString());    // "Clean Code (464 pages)"










##حالا کلاس Library:



public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Book should not be null");
        }
        books.add(book);
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty, no book to borrow");
        }

        Book book = findBook(title);
        if (book == null) {
            throw new BookNotFoundException("Book with title " + title + " not found");
        }

        System.out.println("Book borrowed successfully: " + book);
    }

    public void returnBook(String title) throws BookNotFoundException {
        Book book = findBook(title);
        if (book == null) {
            throw new BookNotFoundException("Book with title " + title + " not found");
        }

        System.out.println("Book returned successfully: " + book);
    }

    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty");
        }

        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }
}



##توضیحات مربوطه :



📖 معرفی کلاس Library



کلاس Library یک سیستم کامل برای مدیریت عملیات کتابخانه شامل افزودن کتاب، امانت دادن، بازپس‌گیری و نمایش لیست کتاب‌ها ارائه می‌دهد.



✨ ویژگی‌های کلیدی



مدیریت مجموعه کتاب‌ها: با استفاده از ArrayList<Book>



اعتبارسنجی هوشمند: بررسی شرایط مختلف با Exceptionهای سفارشی


عملیات اصلی کتابخانه:


افزودن کتاب جدید


امانت دادن کتاب


بازپس‌گیری کتاب


نمایش لیست کتاب‌ها



امنیت داده‌ها: با برگرداندن کپی از لیست کتاب‌ها


🏗️ ساختار و معماری





فیلدها

java
Copy
private ArrayList<Book> books;  // ذخیره‌سازی مجموعه کتاب‌ها


سازنده

java
Copy
public Library()  // ایجاد یک کتابخانه جدید با لیست خالی


🛠️ متدهای اصلی و کاربردها




1. افزودن کتاب (addBook)



java
Copy
public void addBook(Book book) throws InvalidBookException






کاربرد: اضافه کردن یک کتاب جدید به مجموعه





خطاها:



پرتاب InvalidBookException اگر کتاب null باشد


مثال:

java
Copy
try {
    library.addBook(new Book("Design Patterns", 395));
} catch (InvalidBookException e) {
    System.out.println("خطا: " + e.getMessage());
}




2. امانت دادن کتاب (borrowBook)

java
Copy
public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException




کاربرد: ثبت امانت گرفتن یک کتاب




خطاها:

EmptyLibraryException اگر کتابخانه خالی باشد
BookNotFoundException اگر کتاب موجود نباشد


مثال:

java
Copy
try {
    library.borrowBook("Clean Code");
} catch (EmptyLibraryException | BookNotFoundException e) {
    System.out.println("خطا: " + e.getMessage());
}




3. بازپس‌گیری کتاب (returnBook)

java
Copy
public void returnBook(String title) throws BookNotFoundException


کاربرد: ثبت بازگشت یک کتاب


خطاها:

BookNotFoundException اگر کتاب در سیستم نباشد


4. نمایش لیست کتاب‌ها (listBooks)

java
Copy
public void listBooks() throws EmptyLibraryException


کاربرد: نمایش تمام کتاب‌های موجود


خطاها:

EmptyLibraryException اگر کتابخانه خالی باشد


نمونه خروجی:

Copy
Books in the library:
Effective Java (416 pages)
Clean Code (464 pages)


5. دریافت لیست کتاب‌ها (getBooks)



java
Copy
public ArrayList<Book> getBooks()


کاربرد: دریافت کپی ایمن از لیست کتاب‌ها




##کارکرد این کد در حالت کلی : 




این سیستم مدیریت کتابخانه شامل سه بخش اصلی است:



1. کلاس Book (مدل داده کتاب)



وظیفه: نگهداری اطلاعات پایه هر کتاب


داده‌های ذخیره‌شده:


عنوان کتاب (title)


تعداد صفحات (pageCount)


اعتبارسنجی‌ها:


عنوان نمی‌تواند خالی یا null باشد


تعداد صفحات باید مثبت باشد


2. کلاس Library (هسته اصلی سیستم)



وظایف اصلی:


📥 افزودن کتاب جدید به مجموعه (addBook)


📖 امانت دادن کتاب به مراجعین (borrowBook)


↩️ دریافت کتاب بازگردانده شده (returnBook)


📜 نمایش لیست کتاب‌های موجود (listBooks)


مدیریت خطاها:


کتاب نامعتبر (InvalidBookException)


کتاب پیدا نشد (BookNotFoundException)


کتابخانه خالی (EmptyLibraryException)


3. کلاس‌های Exception (مدیریت خطاهای سفارشی)



انواع خطاهای خاص سیستم کتابخانه را تعریف می‌کنند




##در نهایت خروجی کد من به این شکل است :




Library is empty


Error creating book: Page count must be positive


Error creating book: Title cannot be null


Error creating book: Title cannot be empty


Books in the library:


Java Programming (300 pages)


Book borrowed successfully: Java Programming (300 pages)


Book with title Clean Code not found


Book returned successfully: Java Programming (300 pages)


