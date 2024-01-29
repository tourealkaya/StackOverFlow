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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.mastersid.toure.stackoverflow.R
import fr.mastersid.toure.stackoverflow.ui.Question
import fr.mastersid.toure.stackoverflow.viewmodel.QuestionsViewModel

@Composable
fun QuestionListScreen(questionsViewModel: QuestionsViewModel = viewModel()) {
    val questionList by questionsViewModel.questionsList.observeAsState(initial = emptyList())
    val isLoading by questionsViewModel.isLoading.observeAsState(initial = false)

        Box {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(32.dp),
                contentPadding = PaddingValues(16.dp)

            ){
                if(isLoading)
                item {
                    LinearProgressIndicator(modifier = Modifier.align(Alignment.Center)
                        .fillMaxSize(),)
                }
                items(questionList){ question ->
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
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = stringResource(id = R.string.answer_count, question.answerCount),
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(64.dp))
                }

            }
            UpdateQuestionButton(
                updateQuestions = questionsViewModel::updateQuestionsList,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp)
            )


        }
}

@Composable
fun UpdateQuestionButton(updateQuestions: () -> Unit, modifier: Modifier) {
    Button(
        onClick = updateQuestions , modifier = modifier
    ){
        Text("Update Questions")
    } }
