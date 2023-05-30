# RecycleViewAppBar
AppBarLayout scroll use demo

<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="10dp"
    android:fitsSystemWindows="false"
    tools:context=".MainActivity">

    <!--AppbarLayout組合的滾動佈局(RecyclerView, NestedScrollView等),
    需要設定 app:layout_behavior = "@string/appbar_scrolling_view_behavior"
    沒有設定的話,AppbarLayout將不會響應滾動佈局的滾動事件-->
    <com.google.android.material.appbar.AppBarLayout
        android:id="@+id/appbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent">

        <!--scroll | enterAlways
            當任何時候ScrollView往下滾動時，該View會直接往下滾動。而不用考慮ScrollView是否在滾動到最頂部還是哪裡.
            scroll | enterAlways | enterAlwaysCollapsed
            是enterAlways的附加選項，它是指View在往下“出現”的時候，首先是enterAlways效果，當View的高度達到最小高度時，View就暫時不去往下滾動，直到ScrollView滑動到頂部不再滑動時，View再繼續往下滑動，直到滑到View的頂部結束
            scroll | exitUntilCollapsed
            當這個View要往上逐漸"消逝"時，會一直往上滑動，直到剩下的的高度達到它的最小高度後，再響應ScrollView的內部滑動事件。-->
        <com.google.android.material.appbar.CollapsingToolbarLayout
            android:id="@+id/ct"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:contentScrim="#ffffff"
            app:layout_scrollFlags="scroll|exitUntilCollapsed">

            <include
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                layout="@layout/item_account">
            </include>

            <!--layout_collapseMode
                parallax:子View可以選擇在當前的佈局當時是否以"視差"動畫的方式來跟隨滾動。
                （PS:其實就是讓這個View的滾動的速度比其他正常滾動的View速度稍微慢一點）
                pin:將子View位置固定(Pinned position children)：子View可以選擇是否在全域性空間上固定位置，這對於Toolbar來說非常有用，因為當佈局在移動時，可以將Toolbar固定位置而不受移動的影響-->
            <androidx.appcompat.widget.Toolbar
                android:layout_width="match_parent"
                android:layout_height="50dp"
                app:layout_collapseMode="pin">

                <TextView
                    android:id="@+id/toolBar_text"
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:textColor="@color/black"
                    android:textSize="35sp">
                </TextView>
            </androidx.appcompat.widget.Toolbar>
        </com.google.android.material.appbar.CollapsingToolbarLayout>
    </com.google.android.material.appbar.AppBarLayout>

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/r_item"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:itemCount="10">
    </androidx.recyclerview.widget.RecyclerView>
</androidx.coordinatorlayout.widget.CoordinatorLayout>
