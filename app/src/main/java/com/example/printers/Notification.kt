package com.example.printers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printers.data.amjad.MessageData
import com.example.printers.databinding.FragmentNotificationBinding
import com.example.printers.ui.NotificationReadEvent
import com.example.printers.ui.adapter.amjad.MessagesAdapter
import org.greenrobot.eventbus.EventBus

class Notification : Fragment() {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MessagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        callBacks()
    }

    private fun callBacks() {
        binding.ivBackArrow.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_notification_to_homeFragment)
        }
    }

    private fun initRecyclerView() {
        // بيانات تجريبية
        val sampleMessages = listOf(
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),
            MessageData(R.drawable.amjad, "انتهت صلاحية عرض قمت بتفعيله للاستفادة به ولم يتم تطبيقه", "(اليوم) 13 إبريل 2024 - 2:14 م"),
            MessageData(R.drawable.amjad, "تم إضافة عرض جديد لمطاعم المفضلة لديك", "12 إبريل 2024 - 8:00 م"),
            MessageData(R.drawable.amjad, "لقد ربحت قسيمة شراء جديدة", "10 إبريل 2024 - 6:30 م"),

            )

        adapter = MessagesAdapter(sampleMessages,
            { messageData ->
                EventBus.getDefault().post(NotificationReadEvent())
                Log.d("Notification_tag", "Notification clicked: $messageData")}
            )


        binding.rvMessage.layoutManager = LinearLayoutManager(requireContext())


        binding.rvMessage.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
