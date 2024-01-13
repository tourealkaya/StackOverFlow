package fr.mastersid.toure.stackoverflow.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mastersid.toure.stackoverflow.R
import fr.mastersid.toure.stackoverflow.ui.Question

@SuppressLint("RememberReturnType")
@Composable
fun QuestionListScreen() {

    val questionList = rememberSaveable {
        mutableStateOf(
            listOf(
                Question(1, "Kotlin doesn't work", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                Question(2, "short question", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                Question(3, "A very very very very very very long question", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
            )
        )
    }

        Box {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                contentPadding = PaddingValues(16.dp)

            ){
                items(questionList.value){ question ->

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(2f)
                                .padding(end = 16.dp)
                        ) {
                            Text(
                                text = question.title,
                                style = MaterialTheme.typography.displaySmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = question.body,
                                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = stringResource(id = R.string.answer_count, question.answerCount),
                            style = MaterialTheme.typography.displaySmall
                        )
                    }




                }

            }

            Button(

                onClick = {
                    questionList.value = listOf(
                        Question(1, "Question 1", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
                        Question(2, "Question 2", 22, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
                        Question(3, "Question 3", 12, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
                        Question(4, "Question 4", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
                    )
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(text = "update questions")
            }
        }
}