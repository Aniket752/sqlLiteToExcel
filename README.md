<h1> Android SQLLite Tabel To Excel Library </h1>

<p>This libarary helps you to convert your current android database into an excel sheet and you can choose where to store your file in shared storage </p>

<h1> How To Use ❓ </h1>
<P> 
-Using in AppCompatActivity<br>

``` 
val sqlLiteDataBaseToExcel = SqlLiteDataBaseToExcel(activity = this,
                                                    fragment = null, 
                                                    cursor = cursor,
                                                    name = "tableName")
```
-Using in fragment <br>
```
val sqlLiteDataBaseToExcel = SqlLiteDataBaseToExcel(activity = null,
                                                    fragment = this,
                                                    cursor = cursor,
                                                    name = "tableName")
```
<h1> Implementation </h1>

```xml
<repositories>
   <repository>
     <id>jitpack.io</id>
     <url>https://jitpack.io</url>
   </repository>
</repositories>
```
	Step 2. Add the dependency
```xml
<dependency>
	    <groupId>com.github.Aniket752</groupId>
	    <artifactId>sqlLiteToExcel</artifactId>
	    <version>1.0.0</version>
	</dependency>
```
gradle:
	
Add it in your root build.gradle at the end of repositories:
```groovy	
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```	
	Step 2. Add the dependency
```groovy	
implementation 'com.github.Aniket752:sqlLiteToExcel:1.0.0'
```
