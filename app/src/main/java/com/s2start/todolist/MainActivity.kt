package com.s2start.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.s2start.todolist.ui.theme.TodoListTheme
import java.text.SimpleDateFormat
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListTodoScreen()
        }
    }
}

@Composable
fun ListTodoScreen(){
    var items: List<ListTodoModel> = ListTodoModel.listItems()
    TodoListTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                Row {
                    Text(
                        text = "Today",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(Modifier.fillMaxWidth())
                    Text(
                        text = "Hide completed",
                        color = Color.Blue,
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                LazyColumn {
                    items(items) { todoItem ->
                        tarefaItemScreen(todoItem)
                    }
                }
            }
        }
    }
}



@Composable
fun tarefaItemScreen(item:ListTodoModel){
    val checkedState = remember { mutableStateOf(item.isEnabled) }

    Row {
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
        Column {
            Text(text = item.description)
            Text(text = item.dateTime.formaterTime())
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListTodoScreen()
}


data class ListTodoModel(
    var isEnabled:Boolean,
    var description:String,
    var dateTime:Date
){
    companion object{
        fun listItems(): List<ListTodoModel> =
            arrayListOf(
                ListTodoModel(
                    false,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),
                ListTodoModel(
                    false,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),
                ListTodoModel(
                    false,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),
                ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),
                ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                ),   ListTodoModel(
                    true,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                    Date()
                )
            )
    }
}

fun Date.formaterTime():String{
    val formatter = SimpleDateFormat("HH:mm")
    val date = Date()
    return "${formatter.format(date)} PM"
}